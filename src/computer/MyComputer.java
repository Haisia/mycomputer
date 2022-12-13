package computer;

import module.required.cooler.CpuCooler;
import module.required.cpu.Cpu;
import module.required.mainboard.Mainboard;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.storage.Hdd;
import module.required.storage.MDotTwo;
import module.required.storage.Ssd;
import module.required.vga.Vga;

import java.util.List;

// todo : 컴퓨터가 부팅 가능한 상태인지 (조립이 온전한지 ) 확인하는 메서드 구현 및 부팅시 검증
// todo : 컴퓨터 사양에 따른 부팅속도, 작업속도 도출 및 적용
// todo : 연산기능 구현
public class MyComputer implements Computer {
  private Mainboard mainboard;
  private Boolean isTurnOn = false;


  public Boolean isTurnOn() {
    return isTurnOn;
  }

  public void setIsTurnOn(Boolean turnOn) {
    isTurnOn = turnOn;
  }

  public void turnOn() {

    if (isTurnOn){
      System.out.println("컴퓨터를 재부팅합니다. ");
      return;
    }

    if(isBootingAble()) {
      System.out.println("컴퓨터를 부팅합니다. ");
      setIsTurnOn(true);
    }else {
      System.out.println("조립완료후 재시도 해 주세요. ");
    }
  }

  public void turnOff(){
    if (isTurnOn()){
      System.out.println("컴퓨터를 종료합니다. ");
    }else {
      System.out.println("컴퓨터가 이미 꺼져있습니다. ");
    }
    setIsTurnOn(false);
  }

  public void printSpec(){
    System.out.println(mainboard.toString());
  }

  /**
   * 컴퓨터가 부팅 가능한 상태인지 검사합니다.
   * @return 부팅 가능 여부 True / False
   */
  public boolean isBootingAble(){
    // cpu, power cpuCooler, vga, memory 가 최소 1개이상 존재해야 하고,
    // storage (hdd, ssd, m.2) 가 총 1개이상 존재해야 한다.

    return mainboard.getCpu() != null &&
            mainboard.getPower() != null &&
            mainboard.getCpuCooler() != null &&
            mainboard.getVga() != null &&
            mainboard.getMemorys().size() > 0 &&
            (mainboard.getMDotTwo() != null || mainboard.getHdd().size() > 0 || mainboard.getSsd().size() > 0);
  }


  // ------------------------- 조립관련 시작 -------------------------------
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

  public Cpu popCpu(Cpu cpu) throws Exception {
    return mainboard.popCpu(cpu);
  }

  public Power popPower(Power power) throws Exception {
    return mainboard.popPower(power);
  }

  public CpuCooler popCpuCooler(CpuCooler cpuCooler) throws Exception {
    return mainboard.popCpuCooler(cpuCooler);
  }
  public Vga popVga(Vga vga) throws Exception {
    return mainboard.popVga(vga);
  }
  public MDotTwo popMDotTwo(MDotTwo mDotTwo) throws Exception {
    return mainboard.popMDotTwo(mDotTwo);
  }

  // ------------------------- 조립관련 끝 -------------------------------



}
