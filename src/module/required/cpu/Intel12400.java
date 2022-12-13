package module.required.cpu;

import lombok.Getter;

import java.lang.reflect.Executable;

public class Intel12400 implements Cpu {
  private static final double BENCH_SCORE = 0.6;
  @Override
  public Long operation(Executable exe) {
    return null;
  }

  @Override
  public void applyThermalPaste() {

  }

  @Override
  public Long getTemp() {
    return null;
  }

  public double getBENCH_SCORE(){
    return BENCH_SCORE;
  }

}
