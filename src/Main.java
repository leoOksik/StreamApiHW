import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

       /* TODO:  1. Напишите метод, который на вход принимает диапазон лет,
           возвращает список високосных годов в этом диапазоне.
           Примечание: год високосный если он делится на 400 или делится на 4 при этом не делясь на 100.
                2. Напишите метод, который на вход принимает целое число(количество зарплат) и возвращает
           список вещественных чисел, состоящих из случайных зарплат, распределенных по закону нормального
           распределения. Примечание: У нормального распределения есть два параметра: mean(среднее значение)
           и std(среднее отклонение). У класса Random есть метод nextGaussian(), который генерирует нормально
           распределенное число с параметрами mean=0, std=1. Для генерации зарплат попробуйте параметры:
           std = 11190, mean = 29267(можете поподбирать свои). Используйте такую формулу генерации:
           случайная зарплата = nextGaussian() * std + mean.
        */

        leapYear(1999, 2101).forEach(System.out::println);
        System.out.println();
        salaryRandom(10).forEach(System.out::println);

    }

    public static Stream<Integer> leapYear(int yearOne, int yearTwo) {
        return Stream.iterate(yearOne, x -> (x + 1))
                .limit(yearTwo - yearOne + 1).filter(y -> ((y % 400 == 0 || y % 4 == 0 && y % 100 != 0)));
    }

    public static Stream<Double> salaryRandom(int countSalary) {
        return Stream.generate(() -> (new Random().nextGaussian() * 11190 + 29267)).limit(countSalary);
    }
}