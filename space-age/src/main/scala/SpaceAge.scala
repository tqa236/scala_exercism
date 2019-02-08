object SpaceAge{
    private def onPlanet(seconds: Double, earthYear: Double): Double = {
        seconds/(31557600.0*earthYear)
    }
    def onEarth(seconds: Double): Double = onPlanet(seconds, 1.0)
    def onMercury(seconds: Double): Double = onPlanet(seconds, 0.2408467)
    def onVenus(seconds: Double): Double = onPlanet(seconds, 0.61519726)
    def onMars(seconds: Double): Double = onPlanet(seconds,1.8808158)
    def onJupiter(seconds: Double): Double = onPlanet(seconds, 11.862615)
    def onSaturn(seconds: Double): Double = onPlanet(seconds, 29.447498)
    def onUranus(seconds: Double): Double = onPlanet(seconds, 84.016846)
    def onNeptune(seconds: Double): Double = onPlanet(seconds, 164.79132)
}
