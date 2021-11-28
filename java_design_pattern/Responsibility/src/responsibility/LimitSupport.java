package responsibility;

public class LimitSupport extends Support {
    private int limit;                              // �� ��ȣ �̸��̸� �ذ� �Ҽ� �ִ�.
    public LimitSupport(String name, int limit) {   // ������
        super(name);
        this.limit = limit;
    }
    protected boolean resolve(Trouble trouble) {         // �ذ�� �޼ҵ�
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}

