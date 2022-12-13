package module.required.memory;

import module.Module;

public interface Memory extends Module {
  double BENCH_SCORE = 0.3;

  // 연산에 필요한 값 SET, GET
  public void setValue(Long value1, Long value2);
  public Long getValue();

  // 연산에 필요한 연산자 SET, GET
  public void setOperate(String operate);
  public String getOperate(String operate);

  // 메모리 비우기
  public void clearMemory();

  public double getBENCH_SCORE();

}
