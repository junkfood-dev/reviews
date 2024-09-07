package _2024_09_06;

public class TV {
    // 필드(속성)
    String color;
    int size;
    boolean power;
    int channel;
    int volume;

    TV(String color, int size) {
        this.color = color;
        this.size = size;
    }

    // 기능(메소드)
    String printField() {
        return "당신의 TV의 색상은 " + color + "색이고, 크기는 " + size + "인치 입니다.";
    }

    void setPower(boolean power) {
        this.power = power;
        if (power) {
            System.out.println("Hello");
        } else {
            System.out.println("Good Bye");
        }
    }

    void setChannel(int channel) {
        this.channel = channel;
        if (channel < 0 || channel > 999) {
            System.out.println(channel + "번 채널은 없음");
        } else {
            System.out.println(channel + "번 채널로 이동");
        }
    }

    void setVolumeUp () {
        this.volume++;
        if (volume > 30) {
            this.volume = 30;
        }
        System.out.println("볼륨크기 : " + this.volume);
    }

    void setVolumeDown() {
        this.volume--;
        if (volume < 0) {
            this.volume = 0;
        }
        System.out.println("볼륨크기 : " + this.volume);
    }

    public static void main(String[] args) {
        TV tv1 = new TV("파란", 40);
        System.out.println(tv1.printField());
        tv1.setPower(true);
        tv1.setChannel(15);
        tv1.volume = 7;
        tv1.setVolumeUp();
        tv1.setVolumeDown();

        TV tv2 = new TV("빨간", 32);
        tv2.setPower(false);
        tv2.setChannel(-1);
        tv2.volume = 38;
        tv2.setVolumeUp();
        tv2.setVolumeDown();
    }
}
