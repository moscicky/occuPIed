package pl.moscicki.remoteserver;

public class QueueUpdateDto {
  private String username;
  private AccessStatus status;

  public QueueUpdateDto(String username, AccessStatus status) {
    this.username = username;
    this.status = status;
  }

  public AccessStatus getStatus() {
    return status;
  }

  public void setStatus(AccessStatus status) {
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
