
NAME: Puvandraan Wilson
ID: 22002099


public class Seat {
  private String number;
  private boolean status;
  private String client;

  public Seat(String number, boolean status, String client) {
    this.number = number;
    this.status = status;
    this.client = client;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getClient() {
    return client;
  }

  public void setClient(String client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "Seat{" +
        "number='" + number + '\'' +
        ", status=" + status +
        ", client='" + client + '\'' +
        '}';
  }
}