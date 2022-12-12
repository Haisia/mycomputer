package module.required.vga;

import module.submodule.DisplayCable;
import module.submodule.DisplayPort;

import java.util.List;

public class Rtx2070Super implements Vga{
  @Override
  public Long getSize() {
    return null;
  }

  @Override
  public void setDisplayPort(DisplayPort displayPort, DisplayCable cable) {

  }

  @Override
  public DisplayCable getDisplayPort(DisplayPort displayPort) {
    return null;
  }

  @Override
  public List<DisplayCable> getDisplayPorts() {
    return null;
  }
}
