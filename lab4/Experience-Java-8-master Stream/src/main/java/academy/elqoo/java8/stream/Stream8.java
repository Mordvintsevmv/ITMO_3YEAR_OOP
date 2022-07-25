package academy.elqoo.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
        return numbers.stream().map(x -> (int)Math.sqrt(x)).collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
        return user.stream().map(User::getAge).collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
        return users.stream().map(User::getAge).distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
        return (int)users.stream().filter(x -> x.getAge() > 25).count();
    }

    public static List<String> mapToUpperCase(List<String> strings){
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
        return (int)integers.stream().mapToInt(x -> (int)x).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names){
        return names.stream().map(x -> x.split(" ", 2)[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names){
        String s = ((names.stream().collect(Collectors.joining(""))));
        return s.chars().mapToObj(e -> Character.toString((char) e)).distinct().collect(Collectors.toList());

    }

    public static String separateNamesByComma(List<User> users){
        return users.stream().map(User::getName).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users){
        return users.stream().mapToDouble(User::getAge).average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users){
        return users.stream().map(User::getAge).max(Integer::compareTo).get();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().map(User::getAge).min(Integer::compareTo).get();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale,Collectors.groupingBy(User::getAge) ));
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age){
        return users.stream().anyMatch(s -> s.getAge() == age);
    }

    public static boolean noneMatch(List<User> users, int age){
        return users.stream().noneMatch(s -> s.getAge() == age);
    }

    public static Optional<User> findAny(List<User> users, String name){
        return users.stream().findAny();
    }

    public static List<User> sortByAge(List<User> users){
        return users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        return IntStream.iterate(2, n -> n+1 ).filter(Stream8::isPrime).limit(10).boxed().collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        return Stream.generate(new Random()::nextInt).limit(10).collect(Collectors.toList());
    }

    public static User findOldest(List<User> users){
        return users.stream().max(Comparator.comparingInt(User::getAge)).get();
    }

    public static int sumAge(List<User> users){
        return users.stream().mapToInt(x -> (int)x.getAge()).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        return users.stream().mapToInt(User::getAge).summaryStatistics();
    }

}
