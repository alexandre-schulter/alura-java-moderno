import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MainClassCurso {
	public static void main(String args[]) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
			.forEach(c -> System.out.println(c.getNome()));
		
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		Optional<Curso> cursoEncontrado = cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .findFirst();
		
		cursoEncontrado.ifPresent(System.out::println);
		
		int mediaAlunos = (cursos.stream().mapToInt(c -> c.getAlunos()).sum()) / cursos.size();
		OptionalDouble average = cursos.stream().mapToInt(Curso::getAlunos).average();
	}
}
