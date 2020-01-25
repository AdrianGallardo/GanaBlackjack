package com.example.ganablackjack;

public class Estadisticas {
  private int victorias;
  private int derrotas;
  private int empates;
  private int blackjacks;
  private int racha;
  private int aciertos;
  private int errores;

  public Estadisticas() {
    this.victorias = 0;
    this.derrotas = 0;
    this.empates = 0;
    this.blackjacks = 0;
    this.racha = 0;
  }

  public int getVictorias() {
    return victorias;
  }

  public void setVictorias(int victorias) {
    this.victorias = victorias;
  }

  public int getDerrotas() {
    return derrotas;
  }

  public void setDerrotas(int derrotas) {
    this.derrotas = derrotas;
  }

  public int getEmpates() {
    return empates;
  }

  public void setEmpates(int empates) {
    this.empates = empates;
  }

  public int getBlackjacks() {
    return blackjacks;
  }

  public void setBlackjacks(int blackjacks) {
    this.blackjacks = blackjacks;
  }

  public int getRacha() {
    return racha;
  }

  public void setRacha(int racha) {
    this.racha = racha;
  }

  public int getAciertos() {
    return aciertos;
  }

  public void setAciertos(int aciertos) {
    this.aciertos = aciertos;
  }

  public int getErrores() {
    return errores;
  }

  public void setErrores(int errores) {
    this.errores = errores;
  }

  public int proporcionVictorias(){
    return (victorias/(victorias+derrotas))*100;
  }

  public int proporcionAciertos(){
    return (aciertos/(aciertos+errores))*100;
  }

  public void victoria(){
    this.victorias++;
  }

  public void derrota(){
    this.derrotas++;
  }

  public void empate(){
    this.empates++;
  }

  public void blackjack(){
    this.blackjacks++;
  }

  public void racha(){
    this.racha++;
  }

  public void acierto(){
    this.aciertos++;
  }

  public void error(){
    this.errores++;
  }

  public int getJugadas(){
    return aciertos + errores;
  }
}
