2022 Mechanical Mustang Ver. 2

As the robot design became more clear it was apparent that our old code wasn't going to be very useful. Rather than replace all the old files I just created a new repository

This robot will be using CAN bus for control rather than PWM

We will have four main subsystems:
   1. chassis (the drive base)
   2. innerArms (the inner set of arms for climbing)
   3. outerArms (the outer set of arms for climbing)
   4. shooter (this includes ball pickup, advancement and shooting)

The chassis will have encoders if we want to add PID driving later. This may be more of an off season exercise to develop those coding skills. It doesn't really seem like much of a need for this year. The drive motors (two on each side) will be Andy Mark CIM motors with CTRE Talon SRX controllers.

The innerArms and outerArms will each have two motor/controller pairs and will essentially be duplicates as they will function exactly alike. In code we should just create an arm class and then create the two instances that we will need. This class will use the SparkMAX/NEO Brushless motor combination for closed loop control. This will allow us to have very precise control over the movement of the arms (both angle and extension length) for doing the climb at end game. Our goal is an autonomous climb in 30 seconds or less.

The shooter has three sets of motors for ball pickup, loading, and shooting. We will use CTRE Talon SRX controllers with Redline motors for pickup and loading. We will use Spark MAX and Neo for the shooter motors to maintain correct shooting velociy. The pick up and advancement motors won't need encoders.
