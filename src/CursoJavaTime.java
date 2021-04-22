import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CursoJavaTime {

	public static void main(String[] args) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(LocalDate.now().format(formatador));
		
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		
		Period periodo = Period.between(LocalDate.now(), dataFutura);
		
		
	}
	
}
