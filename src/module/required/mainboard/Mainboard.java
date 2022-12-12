package module.required.mainboard;

import module.Module;
import module.required.cooler.CpuCooler;
import module.required.cpu.Cpu;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.storage.Hdd;
import module.required.storage.Ssd;
import module.required.vga.Vga;

import java.util.List;

public interface Mainboard extends Module {
  Cpu pushCpu(Cpu cpu) throws Exception;

  Power pushPower(Power power) throws Exception;

  CpuCooler pushCpuCooler(CpuCooler cpuCooler) throws Exception;

  Vga pushVga(Vga vga) throws Exception;

  List<Hdd> pushHdd(Hdd hdd);

  List<Ssd> pushSsd(Ssd ssd);

  List<Memory> pushMemory(Memory memory);

  @Override
  String toString();
}
