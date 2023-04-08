package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import databank.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); //.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Consumer consumerData = mapper.readValue(new File("src/main/resources/bank_data.json"), new TypeReference<>() {});
        //Task - 1
        System.out.println(countNonNullCreditLimits(consumerData, 0));

        //Task - 2
        System.out.println(maxBalanceAmount(consumerData));

        //Task - 3
        System.out.println(getMaxCreditLimitLastMonths(consumerData, 18));

        //Task - 4
        System.out.println(getDelays(consumerData, 24));

    }

    private static int countNonNullCreditLimits(Consumer consumerData, int minCreditLimit) {
        return (int) consumerData.getConsumerData().getCais().stream()
                .map(CAIS::getCAISDetails)
                .flatMap(Collection::stream)
                .map(CAISDetails::getCreditLimit)
                .filter(Objects::nonNull)
                .mapToInt(creditLimit -> parseBalance(creditLimit.getAmount()))
                .filter(limit -> limit > minCreditLimit)
                .count();
    }
    private static int maxBalanceAmount(Consumer consumerData) {
        return consumerData.getConsumerData().getCais().stream()
                .map(CAIS::getCAISDetails)
                .flatMap(Collection::stream)
                .map(CAISDetails::getBalance)
                .filter(Objects::nonNull)
                .map(Balance::getAmount)
                .filter(Objects::nonNull)
                .mapToInt(Main::parseBalance)
                .max()
                .orElse(0);
    }
    private static int getMaxCreditLimitLastMonths(Consumer consumerData, int months) {
        LocalDate cutoffDate = LocalDate.now().minusMonths(months);
        return consumerData.getConsumerData().getCais().stream()
                .map(CAIS::getCAISDetails)
                .flatMap(Collection::stream)
                .filter(caisDetails -> caisDetails.getCAISAccSwtartDate()
                        .isAfter(cutoffDate))
                .map(CAISDetails::getCreditLimit)
                .filter(Objects::nonNull)
                .map(CreditLimit::getAmount)
                .mapToInt(Main::parseBalance)
                .max()
                .orElse(0);
    }
    private static int getDelays(Consumer consumerData, int month) {
        return (int) consumerData.getConsumerData().getCais().stream()
                .map(CAIS::getCAISDetails)
                .flatMap(Collection::stream)
                .filter(caisDetails -> caisDetails.getCAISAccSwtartDate().isAfter(LocalDate.now().minusMonths(24)))
                .flatMap(caisDetails ->   {
                    int limit = getMonthsOverlap(caisDetails.getCAISAccSwtartDate(), caisDetails.getLastUpdatedDate(),
                            LocalDate.now(), LocalDate.now().minusMonths(month));
                    return caisDetails.getAccountBalances().stream()
                            .map(AccountBalances::getStatus)
                            .limit(limit);
                })
                .filter(s -> !s.equals("U") && !s.equals("0"))
                .count();
    }
    private static int parseBalance(String balanceAmount) {
        return Integer.parseInt(balanceAmount.replaceAll("£", ""));
    }
    private static int getMonthsOverlap(LocalDate p1Date1, LocalDate p1Date2, LocalDate p2Date1, LocalDate p2Date2) {
        LocalDate pStart1 = p1Date1;
        LocalDate pEnd1 = p1Date2;
        LocalDate pStart2 = p2Date1;
        LocalDate pEnd2 = p2Date2;

        if (p1Date1.isAfter(p1Date2)) {
            pStart1 = p1Date2;
            pEnd1 = p1Date1;
        }
        if (p2Date1.isAfter(p2Date2)) {
            pStart2 = p2Date2;
            pEnd2 = p2Date1;
        }

        if (pEnd1.isBefore(pStart2) || pEnd2.isBefore(pStart1)) {
           return 0;
        }
        int MONTHS_INCLUSIVE = 1;
        LocalDate start = pStart1.isAfter(pStart2) ? pStart1 : pStart2;
        LocalDate end = pEnd1.isAfter(pEnd2) ? pEnd2 : pEnd1;
        return (int) ChronoUnit.MONTHS.between(start, end) + MONTHS_INCLUSIVE;
    }
}