package module.required.mainboard;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import module.required.cpu.Cpu;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.vga.Vga;
import module.required.cooler.CpuCooler;
import module.required.storage.Hdd;
import module.required.storage.MDotTwo;
import module.required.storage.Ssd;
import util.MyUtils;

import java.util.ArrayList;
import java.util.List;


@Getter(AccessLevel.PUBLIC)
@Setter
public class B660M implements Mainboard{

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

  @Override
  public Cpu pushCpu(Cpu cpu) throws Exception {
    return MyUtils.pushModule(cpu, "cpu", this) ? getCpu() : null;
  }

  @Override
  public Power pushPower(Power power) throws Exception {
    return MyUtils.pushModule(power, "power", this) ? getPower() : null;
  }

  @Override
  public CpuCooler pushCpuCooler(CpuCooler cpuCooler) throws Exception {
    return MyUtils.pushModule(cpuCooler, "cpuCooler", this) ? getCpuCooler() : null;
  }

  @Override
  public Vga pushVga(Vga vga) throws Exception {
    return MyUtils.pushModule(vga, "vga", this) ? getVga() : null;
  }

  @Override
  public List<Hdd> pushHdd(Hdd hdd) {
    System.out.println("-------------------------------------------");
    System.out.println("하드디스크를 장착합니다.");
    getHdd().add(hdd);
    System.out.println("하드디스크를 장착했습니다. " + "HDD : " + hdd);
    System.out.println("-------------------------------------------");
    return getHdd();
  }

  @Override
  public List<Ssd> pushSsd(Ssd ssd){
    System.out.println("-------------------------------------------");
    System.out.println("SSD를 장착합니다.");
    getSsd().add(ssd);
    System.out.println("SSD를 장착했습니다. " + "SSD : " + ssd);
    System.out.println("-------------------------------------------");
    return getSsd();
  }

  @Override
  public List<Memory> pushMemory(Memory memory){
    System.out.println("-------------------------------------------");
    System.out.println("Memory를 장착합니다.");
    if (getMemorys().size()<RAM_SLOT){
      getMemorys().add(memory);
      System.out.println("Memory를 장착했습니다. " + "Memory : " + memory);
      System.out.println("-------------------------------------------");
      return getMemorys();
    } else {
      System.out.println("* ERROR : 램 소켓이 이미 가득 찼습니다.");
      System.out.println("-------------------------------------------");
      return null;
    }
  }

  public Cpu popCpu(Cpu cpu) throws Exception {
    return MyUtils.popModule(cpu, "cpu", this) ? cpu : null;
  }

  public Power popPower(Power power) throws Exception {
    return MyUtils.popModule(power, "power", this) ? power : null;
  }
  public CpuCooler popCpuCooler(CpuCooler cpuCooler) throws Exception {
    return MyUtils.popModule(cpuCooler, "cpuCooler", this) ? cpuCooler : null;
  }
  public Vga popVga(Vga vga) throws Exception {
    return MyUtils.popModule(vga, "vga", this) ? vga : null;
  }
  public MDotTwo popMDotTwo(MDotTwo mDotTwo) throws Exception {
    return MyUtils.popModule(mDotTwo, "mDotTwo", this) ? mDotTwo : null;
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
