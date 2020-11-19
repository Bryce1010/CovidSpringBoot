# Covid19 SpringBoot

## test model function by curl command

```bash
curl -i -X POST http:182.92.198.167:15000/predict -F "file=@./images/C0K_PA11_SE8.nii.gz/"
```
It's really strange when I use this command on MAC OS some errors occured, so I try it on ubunt instead.

`Failed to open/read local data from file/application`


## test model function by springboot

This is just a toy demo, which aims to serve PyTorch model with SpringBoot. 
 

At first, git clone this repo.

Then, start running springboot project.

Lastly, access `127.0.0.1:8080/detect' , upload the `./images/C0K_PA11_SE8.nii.gz'. 







