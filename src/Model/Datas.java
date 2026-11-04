package Model;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class Datas {
    private Datas() {}

    private static SimpleDateFormat formato(String padrao) {
        SimpleDateFormat formato = new SimpleDateFormat(padrao, Locale.ROOT);
        formato.setLenient(false);
        formato.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        return formato;
    }

    public static Date converter(String texto, String padrao) {
        String expressao = "dd/MM/yyyy HH:mm".equals(padrao)
                ? "[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}:[0-9]{2}"
                : "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        if (texto == null || !texto.matches(expressao)) {
            throw new IllegalArgumentException("Informe uma data válida no formato " + padrao + ".");
        }
        ParsePosition posicao = new ParsePosition(0);
        Date data = formato(padrao).parse(texto, posicao);
        if (data == null || posicao.getIndex() != texto.length()) {
            throw new IllegalArgumentException("Data ou horário inválido: " + texto + ".");
        }
        return data;
    }

    public static String exibir(Date data, String padrao) {
        return data == null ? "" : formato(padrao).format(data);
    }
}
