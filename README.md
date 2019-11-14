#### Train4FAIR Quick Start
http://train4fair.org

#### Pre Requirements
**Add the following lines to the top of the /etc/hosts**

```
0.0.0.0       train.platform.de
::            train.platform.de
```
The environment list name is:
* cloud41 (cloud41.dbis.rwth-aachen.de)
* localhost (127.0.0.1 and cloud41)
* localtotal (127.0.0.1)
* menzel (menzel.informatik.rwth-aachen.de)
* train4fair_com (train4fair.com)
* train4fair_de (train4fair.de)

#### Quick Start by Services Installation (custom mode)
1. `sudo wget http://gofair:gofair@167.172.175.112:9997/installation/development/{environment_name}/installation.tar.gz`
2. `sudo tar xvzf installation.tar.gz`
3. `cd installation`
4. `sudo chmod 777 train_install.sh`
5. `sudo ./train_install.sh --init true`

and 

#### Quick Start by Client Installation (standard mode)
1. `sudo apt install nodejs`
2. `sudo apt install npm`
3. `sudo git clone https://github.com/Train4FAIR/train4fair-client-dashboard.git`
4. `cd train4fair-client-dashboard`
5. `sudo sudo ./start.sh --refresh true --env cloud41`

**Ps.: The clients could run without to be necessary the services. By default they are already pointing to the cloud services.**

or

#### Quick Start by Client Installation (docker mode)
1. `sudo apt install docker-ce`
2. `sudo apt install docker-compose`
3. `sudo wget https://github.com/Train4FAIR/train4fair-client-dashboard/blob/master/packages/node_modules/node-red/client-installation/docker-compose.yml`
4. `sudo docker-compose up`

**Ps.: The clients could run without to be necessary the services. By default they are already pointing to the cloud services.**

#### Getting Help

More documentation can be found [https://groups.google.com/forum/#!forum/train4fair](https://groups.google.com/forum/#!forum/train4fair).


#### Contributing

Before raising a pull-request, please read our
[contributing guide](https://github.com/node-red/node-red/blob/master/CONTRIBUTING.md).

This project adheres to the [Contributor Covenant 1.4](http://contributor-covenant.org/version/1/4/).
 By participating, you are expected to uphold this code. Please report unacceptable
 behavior to any of the project's core team at team@nodered.org.

#### Authors

Train4FAIR is a project of the [Node-RED and OpenJS Foundation](https://openjsf.org).


It was created by [IBM Emerging Technology](https://www.ibm.com/blogs/emerging-technology/).

* Nick O'Leary [@knolleary](http://twitter.com/knolleary) (Node-RED)
* Dave Conway-Jones [@ceejay](http://twitter.com/ceejay) (Node-RED)
* João Bosco Jares [@jbjares](http://twitter.com/jbjares) (Train4FAIR)



#### Copyright and license

Copyright JS Foundation and other contributors, https://openjsf.org under [the Apache 2.0 license](LICENSE).
