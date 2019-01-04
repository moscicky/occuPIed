package pl.moscicki.remoteserver;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
@RequestMapping("/queue")
class QueueEndpoint {

  private final QueueService queueService;

  QueueEndpoint(QueueService queueService) {
    this.queueService = queueService;
  }

  @GetMapping("/all")
  Queue<String> getQueue() {
    return queueService.getQueue();
  }

  @PostMapping
  ResponseEntity<String> addToQueue(@RequestBody @Validated String person) {
    return ResponseEntity.ok().body(queueService.addToQueue(person));
  }
}
