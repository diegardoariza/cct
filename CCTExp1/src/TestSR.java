import ServiceDesk.ServiceDeskManager;

public class TestSR {
	public static void main(String[] args) {
		//Inicializar la aplicacion, crea los hilos asincronos para procesar
		ServiceDeskManager sdm = new ServiceDeskManager();
		sdm.StartAsyncProcessing();
		//Definir el numero de casos de prueba
		int numberOfSRs = 100;
		//--------------------------------------------------
		//Crear los SR de prueba
		for(int i = 0; i < numberOfSRs; i++)
		{
			String srid = sdm.CreateRequest("Mi caso de soporte es " + i);
			System.out.println("The ticket number is: " + srid);
		}
	}
}
