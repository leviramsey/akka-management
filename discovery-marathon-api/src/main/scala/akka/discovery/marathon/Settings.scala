/*
 * Copyright (C) 2017-2024 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.discovery.marathon

import akka.actor._
import akka.annotation.ApiMayChange

@ApiMayChange
@deprecated("Use another discovery method instead.", "1.6.0")
final class Settings(system: ExtendedActorSystem) extends Extension {
  private val marathonApi = system.settings.config.getConfig("akka.discovery.marathon-api")

  val appApiUrl: String =
    marathonApi.getString("app-api-url")

  val appPortName: String =
    marathonApi.getString("app-port-name")

  val appLabelQuery: String =
    marathonApi.getString("app-label-query")
}

@ApiMayChange
@deprecated("Use another discovery method instead.", "1.6.0")
object Settings extends ExtensionId[Settings] with ExtensionIdProvider {
  override def get(system: ActorSystem): Settings = super.get(system)

  override def get(system: ClassicActorSystemProvider): Settings = super.get(system)

  override def lookup: Settings.type = Settings

  override def createExtension(system: ExtendedActorSystem): Settings = new Settings(system)
}
