public class Main {

    // declaracao e inicializacao dos vetores globais com os respectivos valores
    static String vetCiaAerea[]   = { "TAM", "GOL", "AZUL" , "WEBJET" , "COPA" , "AIR FRANCE" , "AMERICAN AIRLINES" , "LAN" , "CONTINENTAL" };
    static String vetPrefixoVoo[] = { "TM" , "GO" , "AZ"   , "WJ"     , "CP"   , "AF"         , "AA"                , "LA"   , "CN" };

    public static void main(String[] args) {
        Passagem passagem = new Passagem();
        passagem.incluir();
    }

}