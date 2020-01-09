package channel_官方文档.高阶函数

object demo {

  def simple_example(): Unit = {
    // 最常见的一个例子是Scala集合类（collections）的高阶函数map
    val salaries = Seq(20000, 70000, 40000)
    var newSalaries = salaries.map((x: Int) => x * 2)
    println(newSalaries)
    newSalaries = salaries.map(x => x * 2)
    println(newSalaries)
    newSalaries = salaries.map(_ * 2)
    println(newSalaries)
  }

  def method_to_function(): Unit = {
    case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

      private def convertCtoF(temp: Double) = temp * 1.8 + 32

      def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
    }
  }

  def receive_func_as_parameter(): Unit = {
    object SalaryRaiser {

      def smallPromotion(salaries: List[Double]): List[Double] =
        salaries.map(salary => salary * 1.1)

      def greatPromotion(salaries: List[Double]): List[Double] =
        salaries.map(salary => salary * math.log(salary))

      def hugePromotion(salaries: List[Double]): List[Double] =
        salaries.map(salary => salary * salary)
    }
  }

  def return_function(): Unit = {
    def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
      val schema = if (ssl) "https://" else "http://"
      (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
    }

    val domainName = "www.example.com"

    def getURL = urlBuilder(ssl = true, domainName)

    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)
  }

  def main(args: Array[String]): Unit = {
    //    simple_example()
    //    method_to_function()
    //    receive_func_as_parameter()
    return_function()
  }
}
