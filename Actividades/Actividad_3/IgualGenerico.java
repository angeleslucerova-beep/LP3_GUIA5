public class IgualGenerico {

//usando equals
public static <E> boolean IgualGey (E obj, E obj2) {
  if ( obj == null ) {
    return obj2 == null;
  }
  return obj.equals(obj2);
}
public static void main (String arg []) {

//crea objetos
Object n = 10;
Object n2 = 10;

//objeto OBJECT
System.out.println("TIPO OBJECT");
System.out.println(IgualGey(n,n2));

//objeto NULL
System.out.println("TIPO NULL");
System.out.println(IgualGey(null, "ñami"));

//objeto INTEGER
System.out.println("TIPO INTEGER");
System.out.println(IgualGey(2,2));

//objeto STRING
System.out.println("TIPO STRING");
System.out.println(IgualGey("HOLA", "HOLI"));
}
}
