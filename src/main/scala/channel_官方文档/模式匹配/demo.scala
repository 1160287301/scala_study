package channel_官方文档.模式匹配

import scala.util.Random


object demo {

  def simple_example(): Unit = {
    val x: Int = Random.nextInt(10)
    val result = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case 2 => "three"
      case _ => "other"
    }
    println(s"$x -> $result")
  }

  def case_class(): Unit = {
    abstract class Notification
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) =>
          s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"you received a Voice Recording from $name! Click the link to hear it: $link"
      }
    }

    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?

    println(showNotification(someVoiceRecording)) //
  }

  def pattern_gaurds(): Unit = {
    // 为了让匹配更加具体，可以使用模式守卫，也就是在模式后面加上if <boolean expression>
    abstract class Notification

    case class Email(sender: String, title: String, body: String) extends Notification

    case class SMS(caller: String, message: String) extends Notification

    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) =>
          s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"you received a Voice Recording from $name! Click the link to hear it: $link"
      }
    }

    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
          "You got an email from special someone!"
        case SMS(number, _) if importantPeopleInfo.contains(number) =>
          "You got an SMS from special someone!"
        case other =>
          showNotification(other) // nothing special, delegate to our original showNotification function
      }
    }

    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

    val someSms = SMS("867-5309", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println(showImportantNotification(someSms, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))
  }

  def only_match_type(): Unit = {
    abstract class Device
    case class Phone(model: String) extends Device {
      def screenOff = "Turning screen off"
    }
    case class Computer(model: String) extends Device {
      def screenSaverOn = "Turning screen saver on..."
    }

    def goIdle(device: Device) = device match {
      case p: Phone => p.screenOff
      case c: Computer => c.screenSaverOn
    }

    println(goIdle(new Phone("")))
  }

  def sealed_class(): Unit = {
    // channel_1.特质（trait）和类（class）可以用sealed标记为密封的，这意味着其所有子类都必须与之定义在相同文件中，
    // 从而保证所有子类型都是已知的
    sealed abstract class Furniture
    case class Couch() extends Furniture
    case class Chair() extends Furniture

    def findPlaceToSit(piece: Furniture): String = piece match {
      case a: Couch => "Lie on the couch"
      case b: Chair => "Sit on the chair"
    }
  }

  def main(args: Array[String]): Unit = {
    //    simple_example()
    //    case_class()
    //    pattern_gaurds()
    //    only_match_type()
    sealed_class()
  }
}
