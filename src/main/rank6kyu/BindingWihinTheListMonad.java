package rank6kyu;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BindingWihinTheListMonad<T, I> {

    public static void main(String[] args) {
        BindingWihinTheListMonad b = new BindingWihinTheListMonad();
        Function<Integer, List<Integer>> function = i -> Arrays.asList(i + 1);
        System.out.println(b.bind(Arrays.asList(1, 2, 3, 4), function));
    }



    public List<I> bind(List<T> list, Function<T, List<I>> func) {
        return list.stream().map(func).flatMap(Collection::stream).collect(Collectors.toList());
    }
}