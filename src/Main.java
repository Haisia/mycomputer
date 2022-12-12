import module.required.cooler.CpuCooler;
import module.required.cooler.IntelBasicCpuCooler;
import module.required.cpu.Cpu;
import module.required.cpu.Intel12400;
import module.required.mainboard.B660M;
import module.required.memory.Memory;
import module.required.memory.Ram;
import module.required.power.Micronix;
import module.required.power.Power;
import module.required.storage.Hdd;
import module.required.storage.Segate;
import module.required.vga.Rtx2070Super;
import module.required.vga.Vga;

public class Main {
  public static void main(String[] args) throws Exception {
    B660M b660M = new B660M();
    Cpu cpu = new Intel12400();
    CpuCooler cpuCooler = new IntelBasicCpuCooler();
    Vga vga = new Rtx2070Super();
    Hdd hdd = new Segate();
    Power power = new Micronix();
    Memory ram = new Ram();


    b660M.pushCpu(cpu);
    b660M.pushPower(power);
    b660M.pushCpuCooler(cpuCooler);
    b660M.pushCpuCooler(cpuCooler);
    b660M.pushVga(vga);
    b660M.pushRam(ram);
    b660M.pushRam(ram);
    b660M.pushRam(ram);
    b660M.pushRam(ram);
    b660M.pushRam(ram);

    b660M.pushHdd(hdd);
    b660M.pushHdd(hdd);
    b660M.pushHdd(hdd);
    b660M.pushHdd(hdd);
    b660M.pushHdd(hdd);
    b660M.pushHdd(hdd);


//    System.out.println("b660M.pushCpu(cpu) = " + b660M.pushCpu(cpu));
    System.out.println("mainboard.toString() = " + b660M.toString());
  }
}