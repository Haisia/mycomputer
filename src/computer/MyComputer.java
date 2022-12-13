package computer;

import lombok.Getter;
import module.required.cooler.CpuCooler;
import module.required.cpu.Cpu;
import module.required.mainboard.Mainboard;
import module.required.memory.Memory;
import module.required.power.Power;
import module.required.storage.Hdd;
import module.required.storage.MDotTwo;
import module.required.storage.Ssd;
import module.required.vga.Vga;
import util.MyUtils;

import java.util.List;

// todo : 연산기능 구현
public class MyComputer implements Computer {
  private Mainboard mainboard;
  private Boolean isTurnOn = false;
  private double speed = 0.1;
  private static final int BOOTING_GAUGE = 10;


  public Boolean isTurnOn() {
    return isTurnOn;
  }

  public void setIsTurnOn(Boolean turnOn) {
    isTurnOn = turnOn;
  }

  public void turnOn() throws InterruptedException {
    if (isTurnOn) {
      System.out.println("컴퓨터를 재부팅합니다. ");
      MyUtils.bootLoading(BOOTING_GAUGE, getSpeed());
    }

    if (isBootingAble()) {
      System.out.println("컴퓨터를 부팅합니다. ");
      setIsTurnOn(true);
    } else {
      System.out.println("조립완료후 재시도 해 주세요. ");
    }
    MyUtils.bootLoading(BOOTING_GAUGE, getSpeed());
  }

  public void turnOff() {
    if (isTurnOn()) {
      System.out.println("컴퓨터를 종료합니다. ");
    } else {
      System.out.println("컴퓨터가 이미 꺼져있습니다. ");
    }
    setIsTurnOn(false);
  }

  public void printSpec() {
    System.out.println(mainboard.toString());
    System.out.println("This computer's speed : " + getSpeed());
  }

  /**
   * 컴퓨터가 부팅 가능한 상태인지 검사합니다.
   *
   * @return 부팅 가능 여부 True / False
   */
  public boolean isBootingAble() {
    // cpu, power cpuCooler, vga, memory 가 최소 1개이상 존재해야 하고,
    // storage (hdd, ssd, m.2) 가 총 1개이상 존재해야 한다.

    return mainboard.getCpu() != null &&
            mainboard.getPower() != null &&
            mainboard.getCpuCooler() != null &&
            mainboard.getVga() != null &&
            mainboard.getMemorys().size() > 0 &&
            (mainboard.getMDotTwo() != null || mainboard.getHdd().size() > 0 || mainboard.getSsd().size() > 0);
  }

  /**
   * 컴퓨터의 속도는 메인보드, cpu, memory 의 벤치점수의 곱으로 정해진다.
   * 0이상 1이하의 속도를 갖고, 1에 가까울수록 빠르다.
   *
   * @return
   */
  private void setSpeed() {
    if (mainboard.getCpu() != null && mainboard.getMemorys().size() > 0) {
      this.speed = mainboard.getBENCH_SCORE() *
              mainboard.getCpu().getBENCH_SCORE() *
              MyUtils.findLowestBenchScoreOfMemorys(mainboard.getMemorys());
    }
  }

  public double getSpeed() {
    setSpeed();
    return speed;
  }

  // ------------------------- 조립관련 시작 -------------------------------
  public MyComputer(Mainboard mainboard) {
    this.mainboard = mainboard;
  }

  public Cpu pushCpu(Cpu cpu) throws Exception {
    setSpeed();
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
    setSpeed();
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
