package prog_serv_proc_clase_01_09_24;


import java.net.*;

public class EjemploURL {
	public static void main(String[] args) {
		URL url;
		URL url2;
		try {
			System.out.println("Constructor simple para una URL:");
			url = new URL("https://www.youtube.com/watch?v=euOEE1lK410");
			Visualizar(url);
			System.out.println("otra URL:");
			url2 = new URL("https://www.google.com/search?q=mini+belligham&sca_esv=596842591&rlz=1C1VDKB_esES1017ES1017&sxsrf=ACQVn0_8NEm3PIH4RawE47wzPl_4zTJrcw%3A1704795387326&ei=-xydZfaHE6WkkdUPveSy4A4&ved=0ahUKEwi28ebbidCDAxUlUqQEHT2yDOwQ4dUDCBA&uact=5&oq=mini+belligham&gs_lp=Egxnd3Mtd2l6LXNlcnAiDm1pbmkgYmVsbGlnaGFtMgcQABiABBgNMgoQABgFGB4YDRgKMggQABgIGB4YDTIIEAAYCBgeGA0yCBAAGAgYHhgNMggQABgIGB4YDTIIEAAYCBgeGA0yCBAAGAgYHhgNMggQABgIGB4YDTIIEAAYCBgeGA1IwhlQwgZY9xdwAngBkAEAmAF3oAHUC6oBBDMuMTG4AQPIAQD4AQGoAhTCAgoQABhHGNYEGLADwgINEC4YgAQYigUYQxiwA8ICBxAjGOoCGCfCAhYQABgDGI8BGOUCGOoCGLQCGIwD2AEBwgIWEC4YAxiPARjlAhjqAhi0AhiMA9gBAcICBBAjGCfCAgoQIxiABBiKBRgnwgIKEC4YgAQYigUYQ8ICEBAAGIAEGIoFGEMYsQMYgwHCAg4QLhiABBiKBRixAxiDAcICBRAuGIAEwgIREC4YgwEYxwEYsQMY0QMYgATCAgsQABiABBixAxiDAcICDBAjGIAEGIoFGBMYJ8ICChAAGIAEGIoFGEPCAg0QLhiABBiKBRhDGLEDwgIFEAAYgATCAggQABiABBixA8ICERAuGIAEGLEDGIMBGMcBGNEDwgIQEC4YgAQYigUYQxjHARjRA8ICDhAAGIAEGIoFGLEDGIMBwgINEAAYgAQYigUYQxjJA8ICCxAAGIAEGIoFGJIDwgITEC4YgAQYigUYQxixAxjHARjRA8ICDhAuGIAEGMcBGK8BGI4FwgIKEAAYgAQYsQMYCsICBxAAGIAEGArCAg4QLhiABBixAxjHARivAcICBRAhGKABwgIFECEYnwXiAwQYACBB4gMFEgExIECIBgGQBgm6BgYIARABGAs&sclient=gws-wiz-serp#vhid=Qs-4ZQe1_7QDqM&vssid=l");
			Visualizar(url2);
		} catch (MalformedURLException e) {
			System.out.println(e);
	}
}
	
	private static void Visualizar(URL url) {
		System.out.println("\tURL completa: " + url);
		System.out.println("\tgetProtocol(): " + url.getProtocol());
		System.out.println("\tgetHost(): " + url.getHost());
		System.out.println("\tgetDefaultPort()" + url.getDefaultPort());
		System.out.println("\tgetPort(): " + url.getPort());
		System.out.println("\tgetPath(): " + url.getPath());
		System.out.println("\tgetQuery(): " + url.getQuery());
		System.out.println("\tgetFile(): " + url.getFile());
		System.out.println("\tgetAuthority(): " + url.getAuthority());
		System.out.println("=======================================================");
		
	}
}
