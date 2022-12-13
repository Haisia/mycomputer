package module.required.cpu;

import module.Module;

import java.lang.reflect.Executable;

public interface Cpu extends Module {
  double BENCH_SCORE = 0.3;

  public Long operation(Executable exe);  // 연산하기
  public void applyThermalPaste();  // 써멀구리스 바르기
  public Long getTemp();  // CPU 온도 확인

  public double getBENCH_SCORE();

}
