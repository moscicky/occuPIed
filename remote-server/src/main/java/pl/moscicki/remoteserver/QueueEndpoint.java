package pl.moscicki.remoteserver;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
@RequestMapping("/queue")
class QueueEndpoint {

  private final QueueService queueService;

  public QueueEndpoint(QueueService queueService) {
    this.queueService = queueService;
  }

  @GetMapping("/all")
  public Queue<String> getQueue() {
    return queueService.getQueue();
  }

  @PostMapping
  public void addToQueue(@RequestBody @Validated String person) {
    queueService.addToQueue(person);
  }
}
