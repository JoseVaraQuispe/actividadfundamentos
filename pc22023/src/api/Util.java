package api;
import com.google.gson.*;
import java.net.URL;
import java.util.Scanner;
import api.domain.Aliado;
import api.domain.Producto;

import org.json.*;

public class Util {
	public static Aliado[] apigwAliados(String addr, String codigo) throws Exception {
		System.out.println("Direccion:" +addr + " Codigo:" +codigo);
		String s = addr + codigo;
		JSONArray  obj2 = null;
		Gson gson = new Gson();
		Aliado[] temp=null;

		URL url;
		try {
			url = new URL(s);
			Scanner scan = new Scanner(url.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();
			System.out.println("Texto:" + str);
			obj2 = new JSONArray (str);
			String res = obj2.toString();
			temp = gson.fromJson(res, Aliado[].class);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return temp;
	}
	public static Producto[] apigwProducto(String addr, String codigo) throws Exception {

		String s = addr + codigo;
		JSONArray obj2 = null;
		Gson gson = new Gson();
		Producto[]  temp= null;
		URL url;
		try {
			url = new URL(s);

			Scanner scan = new Scanner(url.openStream());
			String str = new String();
			while (scan.hasNext())
				str += scan.nextLine();
			scan.close();
			System.out.println("Texto:" + str);
			 obj2 = new JSONArray(str);
			String res = obj2.toString();
	        temp = gson.fromJson(res, Producto[].class);
			System.out.println("Objeto:" + res);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return temp;
	}
}
