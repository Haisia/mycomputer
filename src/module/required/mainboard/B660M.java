package module.required.mainboard;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import module.required.cpu.Cpu;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.vga.Vga;
import module.required.cooler.CpuCooler;
import module.required.memory.Ram;
import module.required.storage.Hdd;
import module.required.storage.MDotTwo;
import module.required.storage.Ssd;
import util.MyUtils;

import java.util.ArrayList;
import java.util.List;


@Getter(AccessLevel.PUBLIC)
@Setter
public class B660M implements Mainboard {

  private static final int UNLIMITED_SLOT = -1;

  private static final int CPU_SLOT = 1;
  private static final int POWER_SLOT = 1;
  private static final int CPUCOOLER_SLOT = 1;
  private static final int VGA_SLOT = 1;
  private static final int MDOTTWO_SLOT = 1;

  private static final int HDD_SLOT = UNLIMITED_SLOT;
  private static final int SSD_SLOT = UNLIMITED_SLOT;
  private static final int RAM_SLOT = 4;


  private Cpu cpu;
  private Power power;
  // TODO: 시쿨은 케이스에 종속되도록 옮기자
//  private List<SystemCooler> systemCoolers;
  private CpuCooler cpuCooler;
  private Vga vga;
  private MDotTwo mDotTwo;
  private List<Hdd> hdd = new ArrayList<>();
  private List<Ssd> ssd = new ArrayList<>();
  private List<Memory> memorys= new ArrayList<>();

  public Cpu pushCpu(Cpu cpu) throws Exception {
    System.out.println("CPU를 장착합니다.");
    return MyUtils.pushModule(cpu, "cpu", this) ? getCpu() : null;
  }

  public Power pushPower(Power power) throws Exception {
    System.out.println("Power를 장착합니다.");
    return MyUtils.pushModule(power, "power", this) ? getPower() : null;
  }

  public CpuCooler pushCpuCooler(CpuCooler cpuCooler) throws Exception {
    System.out.println("CPU 쿨러를 장착합니다.");
    return MyUtils.pushModule(cpuCooler, "cpuCooler", this) ? getCpuCooler() : null;
  }

  public Vga pushVga(Vga vga) throws Exception {
    System.out.println("VGA를 장착합니다.");
    return MyUtils.pushModule(vga, "vga", this) ? getVga() : null;
  }

  public List<Hdd> pushHdd(Hdd hdd) {
    System.out.println("하드디스크를 장착합니다.");
    getHdd().add(hdd);
    return getHdd();
  }

  public List<Ssd> pushSsd(Ssd ssd){
    System.out.println("SSD를 장착합니다.");
    getSsd().add(ssd);
    return getSsd();
  }

  public List<Memory> pushRam(Memory memory){
    System.out.println("RAM 장착합니다.");
    if (getMemorys().size()<RAM_SLOT){
      getMemorys().add(memory);
    } else {
      System.out.println("* 실패 : 램 소켓이 이미 가득 찼습니다.");
    }
    return getMemorys();
  }


  @Override
  public String toString() {
    return "B660M{" +
            "\ncpu= " + cpu +
            "\npower= " + power +
            "\ncpuCooler= " + cpuCooler +
            "\nvga= " + vga +
            "\nmDotTwo= " + mDotTwo +
            "\nhdd= " + hdd +
            "\nssd= " + ssd +
            "\nmemorys= " + memorys +
            '}';
  }
}