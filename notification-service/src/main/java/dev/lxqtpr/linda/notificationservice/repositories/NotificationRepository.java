package dev.lxqtpr.linda.notificationservice.repositories;

import dev.lxqtpr.linda.notificationservice.models.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
}
