package computer;

import module.required.cooler.CpuCooler;
import module.required.cpu.Cpu;
import module.required.mainboard.Mainboard;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.storage.Hdd;
import module.required.storage.Ssd;
import module.required.vga.Vga;
import util.MyUtils;

import java.util.List;

//todo : 컴퓨터 스펙 출력하는 메서드 구현해보자
public class MyComputer implements Computer {
  private final Mainboard mainboard;

  public MyComputer(Mainboard mainboard) {
    this.mainboard = mainboard;
  }

  public Cpu pushCpu(Cpu cpu) throws Exception {
    return mainboard.pushCpu(cpu);
  }

  public Power pushPower(Power power) throws Exception {
    return mainboard.pushPower(power);
  }

  public CpuCooler pushCpuCooler(CpuCooler cpuCooler) throws Exception {
    return mainboard.pushCpuCooler(cpuCooler);
  }

  public Vga pushVga(Vga vga) throws Exception {
    return mainboard.pushVga(vga);
  }

  public List<Hdd> pushHdd(Hdd hdd) {
    return mainboard.pushHdd(hdd);

  }

  public List<Ssd> pushSsd(Ssd ssd) {
    return mainboard.pushSsd(ssd);
  }

  public List<Memory> pushMemory(Memory memory) {
    return mainboard.pushMemory(memory);
  }

}
