package pl.moscicki.remoteserver;

class UserDto {
  private String name;
  private Integer[] uuid;

  UserDto(String name, Integer[] uuid) {
    this.name = name;
    this.uuid = uuid;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  Integer[] getUuid() {
    return uuid;
  }

  void setUuid(Integer[] uuid) {
    this.uuid = uuid;
  }
}
