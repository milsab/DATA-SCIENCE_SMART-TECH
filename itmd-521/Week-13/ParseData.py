
with open("1985.txt", encoding='windows-1252') as readFile, open("dataset.txt", "w") as writeFile:
    i = 0
    for line in readFile:
        i = i + 1
        if i % 1000000 == 0:
            print(i)
        longitude = line[34:41]
        sign = line[34:35]
        f_lon = line[36:38]
        int_lon = int(f_lon)
        if int_lon == 0:
            fnal_lon = "0"
        if int_lon == 1:
            fnal_lon = sign + "10"
        if int_lon == 2:
            fnal_lon = sign + "20"
        if int_lon == 3:
            fnal_lon = sign + "30"
        if int_lon == 4:
            fnal_lon = sign + "40"
        if int_lon == 5:
            fnal_lon = sign + "50"
        if int_lon == 6:
            fnal_lon = sign + "60"
        if int_lon == 7:
            fnal_lon = sign + "70"
        if int_lon == 8:
            fnal_lon = sign + "80"
        if int_lon == 9:
            fnal_lon = sign + "90"
        if int_lon == 10:
            fnal_lon = sign + "100"
        if int_lon == 11:
            fnal_lon = sign + "110"
        if int_lon == 12:
            fnal_lon = sign + "120"
        if int_lon == 13:
            fnal_lon = sign + "130"
        if int_lon == 14:
            fnal_lon = sign + "140"
        if int_lon == 15:
            fnal_lon = sign + "150"
        if int_lon == 16:
            fnal_lon = sign + "160"
        if int_lon == 17:
            fnal_lon = sign + "170"
        if int_lon == 18:
            fnal_lon = sign + "180"
        # handle the + sign in temperature
        if line[87] == '+':
            temperature = line[88:92]
        else:
            temperature = line[87:92]
        quality = line[63:64]
        data = [fnal_lon, quality, temperature]

        try:
            writeFile.write('\t'.join(data) + '\n')
        except:
            print("Error to write data")
        # if i == 10000:
        #     break
    print(i)
try:
    readFile.close()
    writeFile.close()
    print("All Data Successfully wrote to the file!")
except:
    print("error to final wrote")