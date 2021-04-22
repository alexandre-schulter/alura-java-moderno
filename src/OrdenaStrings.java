import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//Collections.sort(palavras);
		//System.out.println(palavras);
		
		//Collections.sort(palavras, new ComparadorDeStringPorTamanho());
		
		//Java8
		//palavras.sort(new ComparadorDeStringPorTamanho());
		
		//Alternativa 1
		palavras.sort((s1, s2) -> {
			if(s1.length() < s2.length())
				return -1;
			if(s1.length() > s2.length())
				return 1;
			return 0;
		});
		
		//Alternativa 2
		palavras.sort((s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());	
		});
		
		//Alternativa 3
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Alternativa 4
		palavras.sort(Comparator.comparing(String::length));
		palavras.sort(Comparator.comparing(String::hashCode));
		
		//Alternativa 5
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		
		//Java8
		//Consumer<String> consumidor = new ConsumidorDeString();
		//palavras.forEach(consumidor);
		palavras.forEach(s -> System.out.println(s));
		
		//Alternativa 2
		palavras.forEach(System.out::println);

		new Thread(() -> System.out.println("Executando um runnable")).start();
		
	}
}


class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
    	if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }
}

class ConsumidorDeString implements Consumer<String> {
	public void accept(String s) {
		System.out.println(s);
	}
}
