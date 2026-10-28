import Model.*;
import java.util.Date;
import java.lang.reflect.*;
public class VerificarModelos {
    private static int verificacoes;
    static void ok(boolean v) { verificacoes++; if(!v) throw new AssertionError("Falha " + verificacoes); }
    public static void main(String[] args) throws Exception {
        Servico s=new Servico(1,"Barba",30f); ok(s.getDescricao().equals("Barba")); ok(s.getValor()==30f);
        s.setDescricao("Corte"); s.setValor(35f); ok(s.getDescricao().equals("Corte") && s.getValor()==35f);
        for(Method m:Servico.class.getDeclaredMethods()) ok(!m.getName().equals("setId") && !m.getName().equals("getId"));
        Cliente c=new Cliente(1,"Jorge",'M',"000","Rua teste"); ok(c.getId()==1 && c.getNome().equals("Jorge") && c.getSexo()=='M'); ok(c.getDataNascimento()==null);
        Date data=new Date(1000); Cliente completo=new Cliente(2,"Ana",'F',data,"000","a@example.test","TESTE","Rua","000");
        data.setTime(0); ok(completo.getDataNascimento().getTime()==1000); Date copia=completo.getDataNascimento(); copia.setTime(0); ok(completo.getDataNascimento().getTime()==1000);
        Usuario u=new Usuario(1,"demo","senha-ficticia"); ok(u.getNivelAcesso()==0); ok(!u.toString().contains("senha-ficticia"));
        Usuario total=new Usuario(2,"Ana","teste",1,'F',new Date(1000),"000","a@example.test","RG","Rua"); ok(total.getNivelAcesso()==1 && total.getDataNascimento().getTime()==1000);
        // Cobertura de todos os pares getter/setter de Cliente e Usuario por reflexão.
        for(Object o:new Object[]{c,u}) for(Field f:o.getClass().getDeclaredFields()) {
            ok(Modifier.isPrivate(f.getModifiers())); String cap=Character.toUpperCase(f.getName().charAt(0))+f.getName().substring(1);
            Object v=f.getType()==int.class ? 7 : f.getType()==char.class ? 'F' : f.getType()==Date.class ? new Date(2000) : "exemplo";
            o.getClass().getMethod("set"+cap,f.getType()).invoke(o,v); ok(o.getClass().getMethod("get"+cap).invoke(o).equals(v));
        }
        System.out.println(verificacoes+" verificações de modelos aprovadas.");
    }
}
