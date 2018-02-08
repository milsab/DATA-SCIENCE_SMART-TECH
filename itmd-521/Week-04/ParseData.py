import mysql.connector

db = mysql.connector.connect(host="localhost",
                     user="root",
                     passwd="itmd521",
                     db="itmd521")

cur = db.cursor()

command = ("INSERT INTO records "
               "(us_station, wb_station, date, hour, latitude, longitude, kind, elevation, wind, quality, visibility, temperature, dew, pressure) "
               "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)")

with open("1985.txt") as file:
    i = 0
    for line in file:
        i = i + 1
        print(i)
        us_station = line[4:10]
        wb_station = line[10:15]
        date = line[15:23]
        hour = line[23:27]
        latitude = line[28:34]
        longitude = line[34:41]
        kind = line[41:46]
        elevation = line[46:51]
        wind = line[60:63]
        quality = line[63:64]
        visibility = line[78:84]
        temperature = line[87:92]
        dewPoint = line[93:98]
        atmosphericPressure = line[99:104]
        data = (us_station, wb_station, date, hour, latitude, longitude, kind, elevation, wind, quality, visibility, temperature, dewPoint, atmosphericPressure)

        try:
            cur.execute(command, data)
        except:
            print("Error to insert in Line: ")
        if i % 100000 == 0:
            try:
                db.commit()
            except:
                print("Error to commit in Line: ")
try:
    db.commit()
    print("All Data Successfully Transfered to MySQL!")
except:
    print("error to final commit")

cur.close()
db.close()