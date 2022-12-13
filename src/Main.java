import computer.MyComputer;
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
    MyComputer myComputer = new MyComputer(b660M);


    Cpu cpu = new Intel12400();
    Cpu cpu2 = new Intel12400();
    CpuCooler cpuCooler = new IntelBasicCpuCooler();
    Vga vga = new Rtx2070Super();
    Hdd hdd = new Segate();
    Power power = new Micronix();
    Memory ram = new Ram();


    myComputer.pushCpu(cpu);
    myComputer.popCpu(cpu);
    myComputer.pushCpu(cpu2);
    myComputer.popCpu(cpu);

    myComputer.pushPower(power);
    myComputer.popPower(power);
    myComputer.popPower(power);

    myComputer.pushCpuCooler(cpuCooler);
    myComputer.popCpuCooler(cpuCooler);
    myComputer.popCpuCooler(cpuCooler);

    //TODO : 모든 ram이 같은 instance 인데도 들어가진다. 같은 instance는 못넣도록 검증하는 부분을 구현하자
    myComputer.pushMemory(ram);
    myComputer.pushMemory(ram);
    myComputer.pushMemory(ram);
    myComputer.pushMemory(ram);
    myComputer.pushMemory(ram);

    myComputer.pushHdd(hdd);
    myComputer.pushHdd(hdd);

    myComputer.pushVga(vga);
    myComputer.pushVga(vga);

    myComputer.pushCpuCooler(cpuCooler);
    myComputer.pushPower(power);

    myComputer.printSpec();

    myComputer.turnOn();
    myComputer.turnOff();

  }
}