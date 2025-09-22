package Desafios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Desafio5 {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 4, 6, 8, 9, 12, 15, 7, 3, 11, 2, 5, -3);

        // Desafio 6: Verificar se a lista contém algum número maior que 10
        boolean temMaiorQue10 = numeros.stream()
                .anyMatch(n -> n > 10);
        System.out.println("Desafio 6 - Contém número maior que 10? " + temMaiorQue10);

        // Desafio 7: Encontrar o segundo número maior da lista
        Optional<Integer> segundoMaior = numeros.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("Desafio 7 - Segundo maior número: " + segundoMaior.orElse(null));

        // Desafio 8: Somar os dígitos de todos os números da lista
        int somaDigitos = numeros.stream()
                .map(n -> String.valueOf(Math.abs(n)))
                .flatMapToInt(s -> s.chars().map(ch -> ch - '0'))
                .sum();
        System.out.println("Desafio 8 - Soma dos dígitos: " + somaDigitos);

        // Desafio 9: Verificar se todos os números da lista são diferentes
        boolean todosDiferentes = numeros.stream()
                .distinct()
                .count() == numeros.size();
        System.out.println("Desafio 9 - Todos os números são diferentes? " + todosDiferentes);

        // Desafio 10: Agrupar os valores ímpares múltiplos de 3 ou de 5
        List<Integer> imparesMultiplos3ou5 = numeros.stream()
                .filter(n -> n % 2 != 0 && (n % 3 == 0 || n % 5 == 0))
                .collect(Collectors.toList());
        System.out.println("Desafio 10 - Ímpares múltiplos de 3 ou 5: " + imparesMultiplos3ou5);

        // Desafio 11: Encontrar a soma dos quadrados de todos os números
        long somaQuadrados = numeros.stream()
                .mapToLong(n -> (long) n * n)
                .sum();
        System.out.println("Desafio 11 - Soma dos quadrados: " + somaQuadrados);

        // Desafio 12: Encontrar o produto de todos os números
        long produto = numeros.stream()
                .mapToLong(n -> n)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Desafio 12 - Produto de todos os números: " + produto);

        // Desafio 13: Filtrar números no intervalo [5, 10]
        List<Integer> intervalo5a10 = numeros.stream()
                .filter(n -> n >= 5 && n <= 10)
                .collect(Collectors.toList());
        System.out.println("Desafio 13 - Números entre 5 e 10: " + intervalo5a10);

        // Desafio 14: Encontrar o maior número primo
        Optional<Integer> maiorPrimo = numeros.stream()
                .filter(Desafio5::isPrime)
                .max(Integer::compareTo);
        System.out.println("Desafio 14 - Maior número primo: " + maiorPrimo.orElse(null));

        // Desafio 15: Verificar se há pelo menos um número negativo
        boolean temNegativo = numeros.stream()
                .anyMatch(n -> n < 0);
        System.out.println("Desafio 15 - Contém número negativo? " + temNegativo);

        // Desafio 16: Agrupar números em pares e ímpares
        Map<Boolean, List<Integer>> paresImpares = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Desafio 16 - Pares: " + paresImpares.get(true));
        System.out.println("Desafio 16 - Ímpares: " + paresImpares.get(false));

        // Desafio 17: Filtrar números primos
        List<Integer> primos = numeros.stream()
                .filter(Desafio5::isPrime)
                .collect(Collectors.toList());
        System.out.println("Desafio 17 - Números primos: " + primos);

        // Desafio 18: Verificar se todos os números são iguais
        boolean todosIguais = numeros.stream()
                .distinct()
                .count() == 1;
        System.out.println("Desafio 18 - Todos os números são iguais? " + todosIguais);

        // Desafio 19: Soma dos números divisíveis por 3 e 5
        long somaDiv3e5 = numeros.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .mapToLong(n -> n)
                .sum();
        System.out.println("Desafio 19 - Soma dos divisíveis por 3 e 5: " + somaDiv3e5);
    }

    // Método auxiliar para verificar se um número é primo
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}


