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

  @PostMapping("/add")
  ResponseEntity<String> addToQueue(@RequestBody @Validated String username) {
    return ResponseEntity.ok().body(queueService.addToQueue(username));
  }

  @PostMapping("/scan")
  ResponseEntity<AccessDto> scanCard(@RequestBody @Validated Integer[] uuid) {
    return ResponseEntity.ok().body(queueService.scan(uuid));
  }

}
