package module.required.memory;

public class Ram implements Memory{

  private static final double BENCH_SCORE = 0.7;

  @Override
  public void setValue(Long value1, Long value2) {

  }

  @Override
  public Long getValue() {
    return null;
  }

  @Override
  public void setOperate(String operate) {

  }

  @Override
  public String getOperate(String operate) {
    return null;
  }

  @Override
  public void clearMemory() {

  }
  public double getBENCH_SCORE() {
    return BENCH_SCORE;
  }
}
