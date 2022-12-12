package module.required.vga;

import module.Module;
import module.submodule.DisplayCable;
import module.submodule.DisplayPort;

import java.util.List;

public interface Vga extends Module {

  public Long getSize();  // 글카 크기

  public void setDisplayPort(DisplayPort displayPort, DisplayCable cable);  // 디스플레이 포트에 케이블을 장착
  public DisplayCable getDisplayPort(DisplayPort displayPort);  // 특정 디스플레이 포트에 장착된 케이블을 조회
  public List<DisplayCable> getDisplayPorts(); // 모든 디스플레이 포트에 장착된 케이블의 리스트를 조회
}
