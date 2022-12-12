package module.required.cpu;

import java.lang.reflect.Executable;

public class Intel12400 implements Cpu {
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
}
