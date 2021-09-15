public class ex10 {
    public static void main(String[] args) {
        double chico = 150;
        double juca = 110;
        int anos = 0;
        while (chico >= juca) {
            chico = chico + 1;
            juca = juca + 4;
        anos = anos + 1;
        }
        System.out.println("Precisarão de "+ anos + " anos para que Juca fique maior que Chico");
        System.out.println("A altura de Chico será " + chico + " CM e a de Juca sera de " + juca +" CM");
    }
}
