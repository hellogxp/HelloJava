### Bring a local folder to remote git repo

```git
 git init
 git add .
 git commit -m "First commit"
```

Sets the new remote

```git
git remote add origin <remote repository URL>
```

Verifies the new remote URL

```git
git remote -v
```

Push the changes in your local repository to GitHub if there is a remote branch called master (or main if that's what
you're using)
```git
git push origin master
```
Otherwise you will have to name local branch first by
```git
git branch -m <new_name>
```
and then push it to add a new branch called <new_name>
```git
git push origin -u <new_name>
```

### Configure your Git username/email

#### To set your global username/email configuration:
1. Open the command line.
2. Set your username:
```git
git config --global user.name "FIRST_NAME LAST_NAME"
```
3. Set your email address:

#### To set repository-specific username/email configuration:
1. From the command line, change into the repository directory.
2. Set your username:
```git
git config user.name "FIRST_NAME LAST_NAME"
```
3. Set your email address:
```git
git config user.email "MY_NAME@example.com"

```
4. Verify your configuration by displaying your configuration file:
```git
cat .git/config
```